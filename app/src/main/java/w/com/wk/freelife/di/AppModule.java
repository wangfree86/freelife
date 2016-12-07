/*
 * Created by wingjay on 11/16/16 3:31 PM
 * Copyright (c) 2016.  All rights reserved.
 *
 * Last modified 11/10/16 11:05 AM
 *
 * Reach me: https://github.com/wingjay
 * Email: yinjiesh@126.com
 */

package w.com.wk.freelife.di;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import w.com.wk.freelife.FreeLifeApplication;

/**
 * Created by Jay on 8/10/16.
 */
@Module
public class AppModule {

  @Provides
  public Gson provideGson(){
    return new Gson();
  }


}
