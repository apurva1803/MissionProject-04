<%@page import="com.sunilos.p4.bean.ServerBean"%>
<%@page import="com.sunilos.p4.ctl.BaseCtl"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@page import="com.sunilos.p4.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%
int pageNo = ServletUtility.getPageNo(request);
int pageSize = ServletUtility.getPageSize(request);
int index = ((pageNo - 1) * pageSize) + 1;
List list = ServletUtility.getList(request);
Iterator<ServerBean> it = list.iterator();
String _err = ServletUtility.getErrorMessage(request);
%>

<div class="container-fluid px-4 py-4" style="max-width: 900px;">
	<div class="card border-0 shadow-sm rounded-4 overflow-hidden">

		<div
			class="card-header text-white border-0 py-3 px-4 d-flex justify-content-between align-items-center"
			style="background: linear-gradient(135deg, #0d2137 0%, #1565c0 100%);">
			<h5 class="mb-0 fw-bold">
				<i class="bi bi-cart me-2"></i> Product List
			</h5>
			<div class="d-flex gap-2">
				<a href="#" target="_blank"
					class="btn btn-sm btn-warning fw-semibold"> <i
					class="bi bi-file-earmark-pdf me-1"></i> Print PDF
				</a> <a href="#?type=doc" target="_blank"
					class="btn btn-sm btn-info fw-semibold"> <i
					class="bi bi-file-earmark-word me-1"></i> Print DOC
				</a> <a href="<%=ORSView.SERVER_CTL%>"
					class="btn btn-sm btn-light text-primary fw-semibold"> <i
					class="bi bi-cart me-1"></i> Add Server
				</a>
			</div>
		</div>

		<form action="<%=ORSView.SERVER_LIST_CTL%>" method="POST">
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">

			<div
				class="p-3 bg-light border-bottom d-flex flex-wrap gap-2 align-items-center">
				
				<input type="text" name="serverName"
					class="form-control form-control-sm" style="max-width: 220px;"
					placeholder="Search by serverName"
					value="<%=ServletUtility.getParameter("serverName", request)%>">
					
				<input type="text" name="ipAddress"
					class="form-control form-control-sm" style="max-width: 220px;"
					placeholder="Search by ipAddress"
					value="<%=ServletUtility.getParameter("ipAddress", request)%>">
					
					
				<button type="submit" name="operation"
					value="<%=BaseCtl.OP_SEARCH%>" class="btn btn-primary btn-sm">
					<i class="bi bi-search me-1"></i> Search
				</button>
				<button type="submit" name="operation"
					value="<%=BaseCtl.OP_DELETE%>"
					class="btn btn-danger btn-sm ms-auto"
					>
					<i class="bi bi-trash me-1"></i> Delete Selected
				</button>
			</div>

			<%
			if (_err != null && !_err.isEmpty()) {
			%>
			<div class="alert alert-danger py-2 mx-3 mt-3">
				<i class="bi bi-exclamation-triangle-fill me-2"></i><%=_err%></div>
			<%
			}
			%>

			<div class="table-responsive">
				<table class="table table-hover align-middle mb-0">
					<thead class="table-dark">
						<tr>
							<th width="40"><input type="checkbox"
								onclick="document.querySelectorAll('input[name=ids]').forEach(c=>c.checked=this.checked)"></th>
							<th>S No.</th>
							<th>Server Name</th>
							<th>IP Address</th>
							<th>CPU Usage</th>
							<th>Status</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tbody>
						<%
						while (it.hasNext()) {
							ServerBean bean = it.next();
						%>
						<tr>
							<td><input type="checkbox" name="ids"
								value="<%=bean.getId()%>"></td>
							<td class="text-muted small"><%=index++%></td>
							<td class="fw-semibold"><%=bean.getServerName()%></td>
							<td><%=bean.getIpAddress()%></td>
							<td><%=bean.getCpuUsage()%></td>
							<td><%=bean.getStatus()%></td>
							<td><a href="ProductCtl?id=<%=bean.getId()%>"
								class="btn btn-sm btn-outline-primary"> <i
									class="bi bi-pencil"></i> Edit
							</a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>

			<div class="p-3 border-top">
				<%@ include file="ListFooter.jsp"%>
			</div>
		</form>
	</div>
</div>