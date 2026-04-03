
<form:form modelAttribute="todo" action="submitForm" method="post">

    <div>
        Username:
        <form:input path="todoTitle"/>
        <form:errors path="todoTitle" cssClass="error"/>
    </div>

    <div>
        Email:
        <form:input path="todoContent"/>
        <form:errors path="todoContent" cssClass="error"/>
    </div>

    <button type="submit">Spring Error Form Register - Text changed 3</button>

</form:form>
