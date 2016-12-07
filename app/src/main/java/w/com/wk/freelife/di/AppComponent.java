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


import javax.inject.Singleton;

import dagger.Component;
import w.com.wk.freelife.MainActivity;
import w.com.wk.freelife.base.BaseActivity;
import w.com.wk.freelife.ui.hold.HoldFragment;


@Singleton
@Component(modules = AppModule.class)

public interface AppComponent {

  void inject(BaseActivity obj);
  /**
   * 需要用到这个连接器的对象，就是这个对象里面有需要注入的属性
   * （被标记为@Inject的属性）
   * 这里inject表示注入的意思，这个方法名可以随意更改，但建议就
   * 用inject即可。
   */
  void inject(MainActivity obj);

  void inject(HoldFragment obj);
}
