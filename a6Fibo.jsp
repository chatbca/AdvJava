<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fibonacci&prime</title>
    </head>
    <body>
        
        <h1>Fibonacci Series</h1>
        <%
         int a=0,b=1,c,i;
         out.println(a+"&nbsp;&nbsp;"+b+"&nbsp;&nbsp;");
         for(i=1;i<=8;i++){
         c=a+b;
         out.println(c+"&nbsp;&nbsp;");
         a=b;
         b=c;
         }
         
         %>
         <h1>PRIME No.series</h1>
         <%
         int pn=2,count=1;
         boolean isprime;
         while(count<=10){
             isprime=true;
             for(i=2;i<=pn/2;i++){
                 if(pn%i==0){
                     isprime=false;
                     break;
                 }
             }
            if(isprime){
            out.println(pn+"&nbsp;&nbsp;");
            count++;
            }
            pn++;
         }
         
         %>
    </body>
</html>
