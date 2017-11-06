package app.com.mvp;


import java.util.ArrayList;
import java.util.HashMap;

import app.com.mvp.mvp.RoutesCallback;
import app.com.mvp.mvp.pojo.RoutesData;
import app.com.mvp.mvp.pojo.RoutesResponse;
import retrofit2.Callback;
import rx.Subscription;

/**
 * Created by Amit
 */

public interface INetwork {
    Subscription callServiceForRotes(RoutesCallback callback, boolean showLoading);

}
