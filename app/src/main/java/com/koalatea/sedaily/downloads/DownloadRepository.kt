package com.koalatea.sedaily.downloads

import android.annotation.SuppressLint
import com.koalatea.sedaily.models.DatabaseModule
import com.koalatea.sedaily.models.Download
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DownloadRepository {
    companion object {
        @SuppressLint("CheckResult")
        fun createDownload(episodeId: String, url: String) {
            // @TODO: Handle disposable
            Observable.just(5)
                .subscribeOn(Schedulers.io())
                .subscribe {
                    val downloadEntry = Download(episodeId, url)
                    DatabaseModule.getDatabase().downloadDao().inserAll(downloadEntry)
                }
        }

        fun getDownloadForId(episodeId: String): Observable<Download> {
            return Observable.fromCallable { DatabaseModule.getDatabase().downloadDao().findById(episodeId) }
        }

        fun removeDownloadForId(episodeId: String): Disposable? {
            return getDownloadForId(episodeId)
                    .subscribeOn(Schedulers.io())
                    .subscribe{
                       DatabaseModule.getDatabase().downloadDao().delete(it)
                    }
        }
    }
}