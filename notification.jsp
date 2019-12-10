<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ page import="java.util.*,java.io.*,java.sql.*"%>
      <%@ page import="niit_utilities.Emp,com.niit.utilities.Dbconnection" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Dairy Farm</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
    <!-- Custom Stylesheet -->
    <link href="css/datatable/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link href="css/style5.css" rel="stylesheet">
   
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div id="preloader">
        <div class="loader">
            <svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
            </svg>
        </div>
    </div>
    <!--*******************
        Preloader end
    ********************-->

    
    <!--**********************************
        Main wrapper start
    ***********************************-->
    <div id="main-wrapper">

        <!--**********************************
            Nav header start
        ***********************************-->
        <div class="nav-header">
            <div class="brand-logo">
                <a href="index.html">
                    <b class="logo-abbr"><img src="images/logo.png" alt=""> </b>
                    <span class="logo-compact"><img src="./images/logo-compact.png" alt=""></span>
                    <span class="brand-title">
                        <img src="images/logo-text.png" alt="">
                    </span>
                </a>
            </div>
        </div>
        <!--**********************************
            Nav header end
        ***********************************-->

        <!--**********************************
            Header start
        ***********************************-->

        <div class="header">    
            <div class="header-content clearfix">
                
                <div class="nav-control">
                    <div class="hamburger">
                        <span class="toggle-icon"><i class="icon-menu"></i></span>
                    </div>
                </div>
                <div class="header-left">
                    <div class="input-group icons">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-transparent border-0 pr-2 pr-sm-3" id="basic-addon1"><i class="mdi mdi-magnify"></i></span>
                        </div>
                        
							
							
                       
                    </div>
                </div>
         <div class="header-right">
                    <ul class="clearfix">
                     
                        <li class="icons dropdown"><a href="javascript:void(0)" data-toggle="dropdown">
                                <i class="mdi mdi-bell-outline"><a href="notification.jsp"><img src="images/notification.png" height="40" width="40" alt=""></i>
                                
                                
                               <%
                                response.setContentType("text/html");  
                           
                                    Connection con=Dbconnection.connect();  
                                    PreparedStatement ps=con.prepareStatement("select count(*) from request_user");  
                                 
                                  //  System.out.println(start1);
                                    ResultSet rs=ps.executeQuery();
                                    //System.out.println(rs);
                                    while(rs.next()){  
                                        
                                        
                                      
                                      
                                      
                                        //e.setEmail(rs.getString(4));  
                                    //   System.out.println(rs.getDate(1)+""+rs.getInt(2)+""+rs.getString(3));
                                       
                           
                                    
                                    
                                     
                              
                                %>
                                
                                
                                
                                
                                
                                
                                <span class="badge badge-pill gradient-2"><%=rs.getInt(1) %></span>
                                <%}
                                    %>
                            </a>
                           
                        <li class="icons dropdown d-none d-md-flex">
                            <a href="javascript:void(0)" class="log-user"  data-toggle="dropdown">
                                <span>English</span>  <i class="fa fa-angle-down f-s-14" aria-hidden="true"></i>
                            </a>
                            <div class="drop-down dropdown-language animated fadeIn  dropdown-menu">
                                <div class="dropdown-content-body">
                                    <ul>
                                        <li><a href="javascript:void()">English</a></li>
                                        <li><a href="javascript:void()">Dutch</a></li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        
                        <li class="icons dropdown">
                            <div class="user-img c-pointer position-relative"   data-toggle="dropdown">
                                <span class="activity active"></span>
                                <img src="images/profile.jpg" height="40" width="40" alt="">
                            </div>
                            <div class="drop-down dropdown-profile   dropdown-menu">
                                <div class="dropdown-content-body">
                                    <ul>
                                        <li>
                                            <a href="Profile1.jsp"><i class="icon-user"></i> <span>Profile</span></a>
                                        </li>
                                        <li>
                                            <a href="email-inbox.html"><i class="icon-envelope-open"></i> <span>Inbox</span> <div class="badge gradient-3 badge-pill badge-primary">3</div></a>
                                        </li>
                                        
                                        <hr class="my-2">
                                        <li>
                                            <a href="page-lock.html"><i class="icon-lock"></i> <span>Lock Screen</span></a>
                                        </li>
                                        <li><a href="page-login.html"><i class="icon-key"></i> <span>Logout</span></a></li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!--**********************************
            Header end ti-comment-alt
        ***********************************-->

        <!--**********************************
            Sidebar start
        ***********************************-->
        <div class="nk-sidebar">           
            <div class="nk-nav-scroll">
                <ul class="metismenu" id="menu">
                    <li class="nav-label">Dashboard</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-speedometer menu-icon"></i><span class="nav-text">Dashboard</span>
                        </a>
                        <ul aria-expanded="false">
                             <li><a href="./index1.html">Home 1</a></li>
                             <li><a href="./Dashboard_admin.jsp">Home 2</a></li>                            
                        </ul>
                    </li>
                    
                    <li class="nav-label">Table</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-menu menu-icon"></i><span class="nav-text">Table</span>
                        </a>
                        <ul aria-expanded="false">
                            
                            <li><a href="table-datatable.jsp" aria-expanded="false">Logout</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-menu menu-icon"></i><span class="nav-text">Logout</span>
                        </a>
                        <ul aria-expanded="false">
                            
                            <li><a href="./login.html" aria-expanded="false">Logout</a></li>
                        </ul>
                    </li>
                   
                </ul>
            </div>
        </div>
        <!--**********************************
            Sidebar end
        ***********************************-->

        <!--**********************************
            Content body start
        ***********************************-->
        <div class="content-body">

            <div class="row page-titles mx-0">
                <div class="col p-md-0">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="javascript:void(0)">Dashboard</a></li>
                        <li class="breadcrumb-item active"><a href="javascript:void(0)">Home</a></li>
                    </ol>
                </div>
            </div>
            <!-- row -->
      
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Data Table</h4>
                                <p>Customer Name</p>
                                <div class="table-responsive">
                                <% 
response.setContentType("text/html");  


List<Emp> list=new ArrayList<Emp>();  

try{  
    Connection con1=Dbconnection.connect();  
    PreparedStatement ps1=con1.prepareStatement("select * from request_user");  
 
  //  System.out.println(start1);
    ResultSet rs1=ps1.executeQuery();
    //System.out.println(rs);
    while(rs1.next()){  
        Emp e=new Emp();  
        e.setcust_id(rs1.getInt(1));  
      
      
        e.setQuantity(rs1.getInt(2));
        //e.setEmail(rs.getString(4));  
    //   System.out.println(rs.getDate(1)+""+rs.getInt(2)+""+rs.getString(3));
       
        list.add(e);  
    }  
    request.setAttribute("list",list);
    
    
    con.close();  
}catch(Exception e){} 
%>
 <table class="table table-striped table-bordered zero-configuration">
                                       
                                            <tr>
                                                <th>Customer_Id</th>
                                                <th>Quantity</th>
                                               
                                                <td>approve</td>
                                                <td>disapprove</td>
                                                
                                            </tr>
                                        
                                    <%for(Emp s:list){ %>
                                        <tfoot>
                                            <tr>
                                                <tr>
                                                <th><%=s.getcust_id()%></th>
                                                <th><%=s.getQuantity()%></th>
                                                
                                                <th><a href="approveServlet?cust_id=<%=s.getcust_id()%>&quantity=<%=s.getQuantity()%>">approve</a></th>
                                            <th><a href="disapprove?cust_id=<%=s.getcust_id()%>">disapprove</a></th>
                                            </tr>
                                            
                                        </tfoot>
                                      <%}%>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #/ container -->
        </div>
        <!--**********************************
            Content body end
        ***********************************-->
        
        
        <!--**********************************
            Footer start
        ***********************************-->
        <div class="footer">
            <div class="copyright">
                <p>Copyright &copy; Designed & Developed by <a href="https://themeforest.net/user/quixlab">Quixlab</a> 2018</p>
            </div>
        </div>
        <!--**********************************
            Footer end
        ***********************************-->
    </div>
    <!--**********************************
        Main wrapper end
    ***********************************-->

    <!--**********************************
        Scripts
    ***********************************-->
    <script src="js/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>

    <script src="js/jquery.dataTables.min.js"></script>
    <script src="js/dataTables.bootstrap4.min.js"></script>
    <script src="js/datatable-basic.min.js"></script>


</body>
</html>