package com.zimo.wangbangqi.utils;

import com.zimo.wangbangqi.enums.TokenEnum;
import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.Map;

public class TokenUtils {
//    //发行版本
//    private static String TOKEN_VERSION = "1";
    //私钥
    private static String SECRET = "ZI_MO_FEI_GONG";

    //The JWT signature algorithm we will be using to sign the token
    public static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;


    public static String createToken(Map<String,Object> claims){
        long nowMills = System.currentTimeMillis();

        claims.put("iss","ZiMO");
        claims.put("exp",new Date(nowMills+ (TokenEnum.TOKEN_TIME_OUT_MIN *60*1000)));
        JwtBuilder jwtBuilder = Jwts.builder().setClaims(claims);
        jwtBuilder.signWith(signatureAlgorithm,SECRET);
        return jwtBuilder.compact();
    }

    /**
     * Token的验证，验证了其是否为服务端签发，以及其有效性。
     * @param token
     * @return
     */
    public static Boolean isValid(String token){
        try {
            Jws<Claims> jwsClaims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.trim());
            Long exp = (Long) jwsClaims.getBody().get("exp");
            return exp - System.currentTimeMillis()>0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    //获取Map集合。
    public static Map<String,Object> parseJWTtoMap(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.trim()).getBody();
        return claims;
    }



}
