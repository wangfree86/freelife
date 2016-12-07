
package w.com.wk.freelife.manager;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import w.com.wk.freelife.utils.ToastUtils;

/**
 * User Management.
 */

public class UserManager {



  @Inject
  UserManager() {}


  public void test(final @NonNull Context context) {
    ToastUtils.showToast("test");
  }


}
