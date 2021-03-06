package com.shanshui.smartcommunity.user.service.exception

/**
 * Created by I336253 on 12/3/2017.
 */
class UserException extends Exception {
    int code
    String message

    private UserException(int code, String message) {
        this.code = code
        this.message = message
    }

    public static final UserException USER_REGISTERED = new UserException(1, 'the cellphone number has been registered')
    public static
    final UserException WRONG_DYNAMIC_CODE = new UserException(2, 'the dynamic code provided is not correct, please get the code again')
    public static final UserException WRONG_TOKEN = new UserException(3, 'token is wrong, please provide correct token')
}
