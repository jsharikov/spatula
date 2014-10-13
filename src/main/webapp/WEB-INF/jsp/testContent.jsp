<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
<thead>
<tr>
<th>Name</th>
<th>Address</th>
<th>Telephone</th>
<th>E-mail</th>
</tr>
</thead>
<tbody>
<c:forEach var="test" items="${listTest}">
<tr>
<td>${test.name}</td>
<td>${test.address}</td>
<td>${test.telephone}</td>
<td>${test.mail}</td>
</tr>
</c:forEach>
</tbody>
</table>