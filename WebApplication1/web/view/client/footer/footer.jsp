<%-- 
    Document   : footer
    Created on : May 5, 2020, 11:25:37 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

        <!-- footer -->  
  <footer id="aa-footer">
    <!-- footer bottom -->
    <div class="aa-footer-top">
     <div class="container">
        <div class="row">
        <div class="col-md-12">
          <div class="aa-footer-top-area">
            <div class="row">
              <div class="col-md-4 col-sm-6">
                <div class="aa-footer-widget">
                  <a href="${pageContext.request.contextPath}/"><img src="${url}/images/logo_footer2.png" alt="logo img" width="185px"></a> 
                  
                  <ul class="aa-footer-nav">

                  </ul>
                </div>
              </div>
              <div class="col-md-4 col-sm-6">
                <div class="aa-footer-widget">
                  <div class="aa-footer-widget">
                    <h3>HỖ TRỢ KHÁCH HÀNG</h3>
                    <ul class="aa-footer-nav">
                      <li><a href="${pageContext.request.contextPath}/view/client/order">Hướng dẫn đặt hàng</a></li>
                      <li><a href="${pageContext.request.contextPath}/view/client/payment">Hướng dẫn thanh toán</a></li>
                      <li><a href="${pageContext.request.contextPath}/view/client/security">Chính sách bảo mật thông tin</a></li>
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-md-4 col-sm-6">
                <div class="aa-footer-widget">
                  <div class="aa-footer-widget">
                    <h3>LIÊN HỆ</h3>
                    <address>

                      <p><span class="fa fa-envelope"></span>bachnshe161333@fpt.edu.vn</p>
                    </address>
                    <div class="aa-footer-social">
                      <a href="https://www.facebook.com/profile.php?id=61560331015883"><span class="fab fa-facebook"></span></a>
                      <a href="#"><span class="fab fa-youtube"></span></a>
                      <a href="#"><span class="fab fa-instagram"></span></a>
                      <a href="#"><span class="fab fa-skype"></span></a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
     </div>
    </div>
    <!-- footer-bottom -->
    <div class="aa-footer-bottom">
      <div class="container">
        <div class="row">
        <div class="col-md-12">
          <div class="aa-footer-bottom-area">
            <div class="aa-footer-payment">
              <span class="fab fa-cc-mastercard"></span>
              <span class="fab fa-cc-visa"></span>
              <span class="fab fa-paypal"></span>
              <span class="fab fa-cc-discover"></span>
            </div>
          </div>
        </div>
      </div>
      </div>
    </div>
  </footer>
  <!-- / footer -->
   
    </body>
     <jsp:include page = "script.jsp" flush = "true" />

</html>
