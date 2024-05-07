package com.Bitts.Configuration;

public class JwtConstant {
    public static final String SECRET_KEY = "5fc2635b7ba245f61a861fa9212917aee83e893f5224eeb0bc8e14b545290f51";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_HEADER = "Authorization";
    public static final int EXPIRATION_TIME=1000 * 60 * 60 * 24 * 7;

}
