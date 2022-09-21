<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<div>
  <h1>Database</h1>
  <br/>
  <div class="row">
    <div class="col-sm-1">
      <form action="./user/" method="get">
        <button class="btn btn-primary" type="submit">See Users</button>
      </form>
    </div>

    <div class="col-sm-1">
      <form action="./car/" method="get">
        <button class="btn btn-primary" type="submit">See Cars</button>
      </form>
    </div>

    <div class="col-sm-1">
      <form action="./booking/" method="get">
        <button class="btn btn-primary" type="submit">See Bookings</button>
      </form>
    </div>
  </div>
</div>

