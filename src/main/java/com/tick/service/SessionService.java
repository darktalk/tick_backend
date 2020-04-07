package com.tick.service;

import java.util.Map;

/**
 * @author lintong
 */
public interface SessionService {
    String generateSessionId(String telephone);
    Map<String, Object> checkSessionId(String sessionId, String telephone);
}
