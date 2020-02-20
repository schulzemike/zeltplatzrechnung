package de.tollefreunde.zeltplatzrechnung.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mike Schulze on 17.03.18.
 */
public class ZPAAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


  @Override
  public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {

    String cfTargetUrl = "/campingfreund/start";
    String zpvTargetUrl = "/zeperlei/start";

    final MyUserPrincipal currentUser = (MyUserPrincipal) authentication.getPrincipal();
    if ("zepalei".equals(currentUser.getUsername())) {
      new DefaultRedirectStrategy().sendRedirect(request, response, zpvTargetUrl);
    } else {
      new DefaultRedirectStrategy().sendRedirect(request, response, cfTargetUrl);
    }
  }
}
