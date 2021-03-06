/*
 * Copyright (c) 2014-2015 Sean Liu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.baoti.pioneer.ui.common.holder;

import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.baoti.pioneer.R;

import static butterknife.ButterKnife.findById;

/**
 * Created by liuyedong on 14-12-30.
 */
public class LoadingViewHolder extends RecyclerView.ViewHolder {
    public final ContentLoadingProgressBar progressBar;
    public final TextView textView;

    public LoadingViewHolder(View itemView) {
        super(itemView);
        progressBar = findById(itemView, android.R.id.progress);
        textView = findById(itemView, android.R.id.text1);
    }

    public LoadingViewHolder setText(CharSequence s) {
        textView.setText(s);
        return this;
    }

    public LoadingViewHolder setText(int textId) {
        if (textId != 0) {
            textView.setText(textId);
        } else {
            textView.setText(null);
        }
        return this;
    }

    public static LoadingViewHolder create(LayoutInflater inflater, ViewGroup parent) {
        return new LoadingViewHolder(inflater.inflate(R.layout.loading_item, parent, false));
    }
}
