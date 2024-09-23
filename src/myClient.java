
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.io.File;


public class myClient 
{

   public static String fetchIndex()
   {
       String url = "http://localhost:9000/";
       try 
       {
    HttpResponse<String> res = Unirest.get("http://localhost:9000/one").asString();
           
       if(res.getStatus() == 200)
       {
           String ans = res.getBody();
           return ans;
       }
       } 
       catch (Exception e) 
       {
       e.printStackTrace();
       return e.toString();
       }
       
      return "error";
   }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public static String userlogin(String username,String password)
   {
       try 
       {
           String url="http://localhost:9000/userlogin";
           HttpResponse<String> res = Unirest.get(url)
                   .queryString("username", username)
                   .queryString("password", password)
                   .asString();
           
       if(res.getStatus() == 200)   //ok status
       {
           String ans = res.getBody();
           return ans;
       }
       } 
       catch (Exception e) 
       {
          e.printStackTrace();
          return e.toString();
       }
       
      return "error";
   }
     public static String usersignup(String email,String pass,String mobile)
   {
       try 
       {
           String url="http://localhost:9000/usersignup";
           HttpResponse<String> res = Unirest.get(url)
                   .queryString("email",email)
                   .queryString("pass", pass)
                   .queryString("mobile",mobile)
                   .asString();
           if(res.getStatus()==200)
           {
               return res.getBody();
           }
       
       } 
       catch (Exception e) 
       {
           e.printStackTrace();
         return  e.toString();
       }
       
      return "error";
   }
     public static String verifyemail(String email)
     {
         try
         {
             String url="http://localhost:9000/verifyemail";
             HttpResponse<String> res = Unirest.get(url)
                   .queryString("email",email)
                    .asString();
             if(res.getStatus()==200)
           {
               return res.getBody();
           }
       
             
         }
         catch(Exception e)
         {
             e.toString();
         }
         return "error";
         
     }
     public static String fetchcat()
     {
         try
         {
             String url="http://localhost:9000/fetchcat";
             HttpResponse<String> res = Unirest.get(url)
                    .asString();
             if(res.getStatus()==200)
           {
               return res.getBody();
           }
            else
            {
                 return "server error";
            }
       
             
         }
         catch(Exception e)
         {
             e.toString();
         }
         return "error";
     }
     public static String AdminLogin(String name,String pass)
     {
         try
         {
             String url="http://localhost:9000/AdminLogin";
             HttpResponse<String> res=Unirest.get(url)
                     .queryString("name", name)
                     .queryString("pass", pass)
                     .asString();
             if(res.getStatus()==200)
             {
                 return res.getBody();
             }
             else
             {
                 return "server error";
             }
             
         }
         catch(Exception e)
         {
             return e.toString();
         }

     }
     public static String AddCategory(String category,File ph)
     {
         try
         {
             String url="http://localhost:9000/AddCategory";
             HttpResponse<String> res=Unirest.post(url)
                     .queryString("category", category)
                     .field("f1", ph)
                     .asString();
             if(res.getStatus()==200)
             {
                 return res.getBody();
             }
             else
             {
                 return "server error";
             }
             
         }
         catch(Exception e)
         {
             return e.toString();
         }

     }
     public static String fetchcategories()
     {
         try
         {
             String url="http://localhost:9000/fetchcategories";
             HttpResponse<String> res=Unirest.get(url)
                     .asString();
             if(res.getStatus()==200)
             {
                 return res.getBody();
             }
             else
             {
                 return "server error";
             }
             
         }
         catch(Exception ex)
         {
             return ex.toString();
         }
     }
     public static  String addmovies(String category,String movie_name,String direct,String cast,String youtube_id,File ph1,File movie_link)
     {
         try
         {
             String url="http://localhost:9000/addmovies";
             HttpResponse<String> res=Unirest.post(url)
                     .queryString("category", category)
                     .queryString("movie_name", movie_name)
                     .queryString("direct", direct)
                     .queryString("cast", cast)
                     .queryString("youtube_id", youtube_id)
                     .field("f2", ph1)
                     .field("movie_link", movie_link)
                     .asString();
             if(res.getStatus()==200)
             {
                 return res.getBody();
             }
             else
             {
                 return "server error";
             }
             
         }
         catch(Exception ex)
         {
             return ex.toString();
         }
     }
     public static String fetchmovies(String catname)
     {
         try
         {
             String url="http://localhost:9000/fetchmovies";
             HttpResponse<String> res=Unirest.get(url)
                     .queryString("catname", catname)
                     .asString();
             if(res.getStatus()==200)
             {
                 return res.getBody();
             }
             else
             {
                 return "server error";
             }
         }
         catch(Exception e)
         {
             return e.toString();
         }
     }
     public static String moviedetail(int id)
     {
         try
         {
             String url="http://localhost:9000/moviedetail";
             HttpResponse<String> res=Unirest.get(url)
                     .queryString("id",id)
                     .asString();
             if(res.getStatus()==200)
             {
                 return res.getBody();
             }
             else
             {
                 return "server error";
             }
                     
             
         }
         catch(Exception e)
         {
             return e.toString();
         }
     }
     public static String search(String name)
     {
         try
         {
           String url="http://localhost:9000/search";
             HttpResponse<String> res=Unirest.get(url)
                    .queryString("name",name)
                    .asString(); 
             if(res.getStatus()==200)
             {
                 return res.getBody();
             }
             else
             {
                 return "server error";
             }
                     

  
         }
         catch(Exception ex)
         {
             ex.printStackTrace();
             return null;
         }
     }

 }
