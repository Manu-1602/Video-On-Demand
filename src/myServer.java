
import com.vmm.JHTTPServer;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class myServer extends JHTTPServer
{
     
    
    public myServer(int port) throws IOException 
    {
        super(port);
    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) 
    {
        Response res = null;
        
    if(uri.equals("/"))
    {
        String ans = Math.random()+"";
       
        res = new Response(HTTP_OK, "text/plain", ans);
        
        return res;
    }
    else if(uri.equals("/one"))
    {
        String ans = Math.random()+"";
       
        res = new Response(HTTP_OK, "text/plain", ans);
        
        return res;
    }
    else if(uri.equals("/userlogin"))
    {
        String username=parms.getProperty("username");
        String password =parms.getProperty("password");
        
        try
        {
            ResultSet rs=DBLoader.executeSQL("select * from users where useremail='"+username+"' and password ='"+password+"'");
            if(rs.next())
            {
                 res = new Response(HTTP_OK, "text/plain", "sucess");
        
            }
            else
            {
                 res = new Response(HTTP_OK, "text/plain", "fail");
        
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                
        
    }
    else if(uri.equals("/usersignup"))
    {
        String email=parms.getProperty("email");
        String password=parms.getProperty("pass");
        String mobile =parms.getProperty("mobile");
        try 
        {
             ResultSet rs1= DBLoader.executeSQL("select * from users where mobile='"+mobile+"'");
                    if(rs1.next())
                    {
                       res = new Response(HTTP_OK, "text/plain", "mobile"); 
                    }
                    else
                    {
                       
                        rs1.moveToInsertRow();
                        rs1.updateString("useremail",email);
                        rs1.updateString("password",password);
                        rs1.updateString("mobile", mobile);
                        rs1.insertRow();
                        res = new Response(HTTP_OK, "text/plain", "sucess"); 
                    
                    }
        } 
        catch (Exception e) 
        {
            
            e.printStackTrace();
           // res = new Response(HTTP_OK, "text/plain", "failed");
        }
                
    }
    else if(uri.equals("/verifyemail"))
    {
        String email=parms.getProperty("email");
        
        try
        {
            ResultSet rs=DBLoader.executeSQL("select * from users where useremail='"+email+"'");
            if(rs.next())
            {
               res = new Response(HTTP_OK, "text/plain", "exist");  
        
            }
            else
            {
                
                String otp =  (int) (1000+(9999-1000)*Math.random())+"";
                sendemail obj = new sendemail(email,"hello","Your Otp is: "+otp);
                //set otp to global
                //GLOBAL.myotp=otp;
                res = new Response(HTTP_OK, "text/plain", otp);
                
            }
       
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     
    }
    else if(uri.equals("/fetchcat"))
    {
        String ans="";
        try
        {
            ResultSet rs=DBLoader.executeSQL("select * from category");
            while(rs.next())
            {
                String name=rs.getString("name");
                String photo=rs.getString("photo");
                String row=name+"$"+photo;
                ans=ans+row+";;";
                res = new Response(HTTP_OK, "text/plain", ans);
            }
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    else if(uri.equals("/AdminLogin"))
    {
        String name=parms.getProperty("name");
        String pass=parms.getProperty("pass");
        try
        {
           ResultSet rs=DBLoader.executeSQL("select * from admin where username='"+name+"' and password='"+pass+"'");
           if(rs.next())
           {
               res = new Response(HTTP_OK, "text/plain", "sucess"); 
           }
           else
           {
               res = new Response(HTTP_OK, "text/plain", "fail"); 
           }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    else if(uri.equals("/AddCategory"))
    {
        String cat=parms.getProperty("category");
        String name=saveFileOnServerWithRandomName(files, parms, "f1", "src/uploads/");
        try
        {
            ResultSet rs=DBLoader.executeSQL("select * from category where name='"+cat+"' and photo= '"+name+"'");
            if(rs.next())
            {
                 res = new Response(HTTP_OK, "text/plain", "exist"); 
            }
           else
           {
               rs.moveToInsertRow();
               rs.updateString("name", cat);
               rs.updateString("photo", "src/uploads/"+name);
               rs.insertRow();
               res = new Response(HTTP_OK, "text/plain", "sucess"); 
               
               
           }
        }
                
     
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    else if(uri.equals("/fetchcategories"))
    {
        String ans="";
        try
        {
            ResultSet rs=DBLoader.executeSQL("select * from category");
            while(rs.next())
            {
                String name=rs.getString("name");
                String row=name;
                ans=ans+row+";;";
                res = new Response(HTTP_OK, "text/plain", ans); 
                
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    else if(uri.equals("/addmovies"))
    {
        String category=parms.getProperty("category");
        String movie=parms.getProperty("movie_name");
        String director=parms.getProperty("direct");
        String starcast=parms.getProperty("cast");
        String youtube=parms.getProperty("youtube_id");
        String name= saveFileOnServerWithRandomName(files, parms, "f2", "src/uploads/");
        String movie_name=saveFileOnServerWithRandomName(files, parms,"movie_link", "src/uploads/movies/");
        try
        {
               ResultSet rs=DBLoader.executeSQL("select * from movies");
               rs.moveToInsertRow();
               rs.updateString("movie_name", movie);
               rs.updateString("director", director);
               rs.updateString("cast", starcast);
               rs.updateString("movie_link", "src/uploads/movies/"+movie_name);
               rs.updateString("trailer", youtube);
               rs.updateString("category", category);
               rs.updateString("photo", "src/uploads/"+name);
               rs.insertRow();
               res = new Response(HTTP_OK, "text/plain", "sucess");
           
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }
        
        
    }
    else if(uri.equals("/fetchmovies"))
    {
        String catname=parms.getProperty("catname");
        String ans="";
        try
        {
             ResultSet rs=DBLoader.executeSQL("select * from movies where category='"+catname+"'");
             while(rs.next())
             {
                 int Id=rs.getInt("Id");
                 String movie_name=rs.getString("movie_name");
                 String photo=rs.getString("photo");
                 String row=Id+"$"+movie_name+"$"+photo;
                 ans=ans+row+";;";
                 res = new Response(HTTP_OK, "text/plain", ans);
                 
                 
             }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
       
        
    }
    else if(uri.equals("/moviedetail"))
    {
        int id=Integer.parseInt(parms.getProperty("id"));
        try
        {
          ResultSet rs=DBLoader.executeSQL("select * from movies where id="+id);
          if(rs.next())
          {
              String name=rs.getString("movie_name");
              String director=rs.getString("director");
              String cast=rs.getString("cast");
              String youtube_id=rs.getString("trailer");
              String photo=rs.getString("photo");
              String movie_link=rs.getString("movie_link");
              String row=name+"$"+director+"$"+cast+"$"+youtube_id+"$"+photo+"$"+movie_link;
              res = new Response(HTTP_OK, "text/plain", row);
              
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    else if(uri.equals("/search"))
    {
        String name=parms.getProperty("name");
        String ans="";
        try
        {
            ResultSet rs=DBLoader.executeSQL("select * from movies where movie_name like'%"+name+"%'");
            while(rs.next())
             {
                 int Id=rs.getInt("Id");
                 String movie_name=rs.getString("movie_name");
                 String photo=rs.getString("photo");
                 String row=Id+"$"+movie_name+"$"+photo;
                 ans=ans+row+";;";
                 res = new Response(HTTP_OK, "text/plain", ans);
                 
                 
             }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    return res;
    }
    
    
}
          
    

//    public static void main(String[] args) {
//        
//        try 
//        {
//             myServer obj = new myServer(9000);
//             Thread.sleep(1000000000);
//        } 
//        catch (Exception e) 
//        {
//         e.printStackTrace();
//        }
//        
//       
//        
//    }
    


