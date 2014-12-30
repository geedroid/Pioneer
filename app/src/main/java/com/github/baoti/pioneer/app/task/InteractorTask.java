package com.github.baoti.pioneer.app.task;

import com.github.baoti.pioneer.biz.exception.BizException;
import com.github.baoti.pioneer.biz.interactor.DeferredInteractor;

import retrofit.RetrofitError;

/**
 * 后台交互任务
 *
 * Created by liuyedong on 14-12-25.
 */
public class InteractorTask<Progress, Result> extends SafeAsyncTask<Void, Progress, Result> {
    private final DeferredInteractor<Result> deferredInteractor;

    public InteractorTask(DeferredInteractor<Result> interactor) {
        super();
        this.deferredInteractor = interactor;
    }

    public InteractorTask(DeferredInteractor<Result> interactor,
                          boolean subscribe) {
        super(subscribe);
        this.deferredInteractor = interactor;
    }

    @Override
    protected Result doTask(Void... params) throws BizException {
        try {
            return deferredInteractor.interact();
        } catch (RetrofitError error) {
            throw new BizException(error.getLocalizedMessage(), error);
        }
    }
}