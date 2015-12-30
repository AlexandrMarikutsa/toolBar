/*
 * ExtractAssetTask.java
 *   PSPDFKit
 *
 *   Copyright (c) 2014-2016 PSPDFKit GmbH. All rights reserved.
 *
 *   THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
 *   AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE PSPDFKIT LICENSE AGREEMENT.
 *   UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
 *   This notice may not be removed from this file.
 */

package com.demo.alexandr.myapp.tasks;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ExtractAssetTask extends AsyncTask<String, Void, Uri> {

    private final Context ctx;
    private final DownloadDocumentTask.DownloadedFileCallback callback;

    public ExtractAssetTask(Context ctx, DownloadDocumentTask.DownloadedFileCallback callback) {
        this.ctx = ctx.getApplicationContext();
        this.callback = callback;
    }

    @Override
    protected Uri doInBackground(String... params) {

        for (String asset : params) {
            try {
                InputStream is = ctx.getResources().getAssets().open(asset);
                File f = new File(ctx.getFilesDir(), asset);
                OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
                byte[] buffer = new byte[8192];
                int read;
                while ((read = is.read(buffer)) != -1) {
                    os.write(buffer, 0, read);
                }

                os.close();
                is.close();

                return Uri.fromFile(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(Uri uri) {
        if (callback != null)
            callback.onFileDownladed(uri);
    }
}
