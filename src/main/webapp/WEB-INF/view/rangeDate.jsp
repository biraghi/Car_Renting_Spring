<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<div>
    <h1>Auto Disponibili</h1>
    <p>Inserire la data di inizio e di fine del noleggio</p>
    <br/>
    <div class="input-group mb-3 ">
        <form action="./list" method="get">
            <p><strong>Start Date</strong></p>
            <input type="date" class="form-control" name="startDate"  aria-describedby="basic-addon2"><br>
            <p><strong>Finish Date</strong></p>
            <input type="date" class="form-control" name="finishDate"  aria-describedby="basic-addon2"><br>
            <button class="btn btn-primary" type="submit">Submit</button>
        </form>
    </div>
</div>

