package com.alive.alive.Models.AppCommon;

import com.alive.alive.Common.Response;
import com.alive.alive.Common.ResponseState;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//import com.hci.smarthypermarket.views.IShowableItem;
import android.os.AsyncTask;
import android.util.Log;

abstract class RetrieveUserTask extends AsyncTask<User, Integer, User> {
    // ////////////////////////////
    final String TAG_UEMAIL = "email";
    final String TAG_UPASSWORD = "password";
    final String TAG_UID = "id";
    final String TAG_SUCCESS = "success";
    final String TAG_USER = "user";
    final String TAG_UFIRSTNAME = "firstName";
    final String TAG_ULASTNAME = "lastName";
    // //////////////////////////////////

    JSONParser jsonParser = new JSONParser();
    //List<Review> reviewlist= new ArrayList<Review>();
    JSONArray reviews = null;
    private static final String url_product_detials = Model.WebServiceParent + "/users/login";
    private User u = new User();
    @SuppressWarnings("finally")
    @Override
    protected User doInBackground(User... params) {
// TODO Auto-generated method stub
        try {
            int success;
            List<NameValuePair> CParams = new ArrayList<NameValuePair>();
            CParams.add(new BasicNameValuePair("email", params[0].Email));
            CParams.add(new BasicNameValuePair("password", params[0].Password));
            JSONObject json = jsonParser.makeHttpRequest(url_product_detials,
                    "GET", CParams);
            success = json.getInt(TAG_SUCCESS);
            if (success == 1) {
                JSONObject userObj = json.getJSONObject(TAG_USER);
                int id = Integer.parseInt(userObj.getString(TAG_UID));
                String email = userObj.getString(TAG_UEMAIL);
                String firstName = userObj.getString(TAG_UFIRSTNAME);
                String lastName = userObj.getString(TAG_ULASTNAME);
                //String name = productObj.getString(TAG_NAME);
                //String barcode = productObj.getString(TAG_BARCODE);
                //float price = Float.parseFloat(productObj.getString(TAG_PRICE));
                //String Discription = productObj.getString(TAG_PDISC);
                //String Weight = productObj.getString(TAG_PWIGH);
                //reviews = productObj.getJSONArray(Tag_Review);
                //Log.d("reviews", reviews.toString());
                //for(int i =0;i<reviews.length();i++)
                //{
                //    JSONObject reviewobject=reviews.getJSONObject(i);
                //    String reviewid= reviewobject.getString(Tag_ReviewId);
                //    String reviewbody = reviewobject.getString(Tag_ReviewBody);
                //    JSONObject userobject=reviewobject.getJSONObject(Tag_User);
                //    String userid=userobject.getString(Tag_UserId);
                //    String userfirstName=userobject.getString(Tag_UserFirstName);
                //    String userlaStringName=userobject.getString(Tag_UserLastName);
                //    String mobilenumber=userobject.getString(Tag_UserMobile);
                //    String rcreatedat=userobject.getString(Tag_ReviewCreateTime);
                //    String rupdatedat=	userobject.getString(Tag_ReviewUpdateTime);
                //    String rating =userobject.getString(Tag_Rating);
                //    Review review = new Review(new Shopper(userfirstName,userlaStringName,mobilenumber),reviewid,reviewbody,rcreatedat,rupdatedat,Integer.parseInt(rating));
                //    reviewlist.add(review);
                //}
// String categoryId = productObj.getString(TAG_CATID);
                //Log.d("reviewslength", Integer.toString(reviewlist.size()));
                u = new User(id, email, firstName, lastName);
                return u;
            } else {
            }
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                return u;
            }
    }
}

abstract class SendUserTask extends AsyncTask<User, Integer, User>
{
    /////////////////Reviews Tags////////////////
    final String Tag_ReviewBody="body";
    final String Tag_ProductId="product_id";
    final String Tag_UserId="user_id";
    final String Tag_Updatedat="updated_at";
    final String Tag_Createdat="created_at";
    final String Tag_ReviewID="id";
    final String Tag_UserMobile="mobile";
    final String Tag_Rating = "rating";

    final String Tag_Email = "email";
    final String Tag_Username = "username";
    final String Tag_Password = "password";
    //////////////////////////////////////////
    private static final String url_create_user = Model.WebServiceParent + "/users/create";
    JSONParser jsonParser = new JSONParser();
    @Override
    protected User doInBackground(User... params) {
// TODO Auto-generated method stub
        List<NameValuePair> CParms = new ArrayList<NameValuePair>();
        CParms.add(new BasicNameValuePair(Tag_Email, params[0].Email));
        CParms.add(new BasicNameValuePair(Tag_Username, params[0].Username));
        CParms.add(new BasicNameValuePair(Tag_Password, params[0].Password));
        JSONObject jsonObject = jsonParser.makeHttpRequest(url_create_user, "GET", CParms);
        try {
            String Createdat=jsonObject.getString(Tag_Createdat);
            String Updatedat=jsonObject.getString(Tag_Updatedat);
            String ReviewId=jsonObject.getString(Tag_ReviewID);
            //params[0].createdAt=Createdat;
            //params[0].updatedAt=Updatedat;
            //params[0].id=ReviewId;
        } catch (JSONException e1) {
// TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return params[0];
    }
}

/**
 * Created by yessir on 26/09/14.
 */
public class User extends Model {
    public String Username;
    public String Password;
    public String Email;
    public String FirstName;
    public String LastName;
    public List<Object> Objects;
    public static User LoggedInUser = null;
    //public RestClient HttpClient = null;
    public static String WebserviceURLFull = Model.WebServiceParent + "/users";

    public User() { }
    public User(String email)
    {
        Email = email;
    }
    public User(int id, String email)
    {
        Id = id;
        Email = email;
    }
    public User(int id, String email, String firstName, String lastName)
    {
        Id = id;
        Email = email;
        FirstName = firstName;
        LastName = lastName;
    }
    public User(String email, String password)
    {
        Email = email;
        Password = password;
    }

    //public RestClient HttpClient {
    //    if (User._httpClient == null)
    //        User._httpClient = new RestClient(Model._webserviceURLParent);
    //
    //    return User._httpClient;
    //}

    static public User GetLoggedUser()
    {
        return LoggedInUser;
    }

    public Response Create()
    {
        Response respone = new Response();

        if (Email == "" || Password == "" || Username == "")
            respone.Errors.add(new Error("Email or Password or Username isnt set"));

        SendUserTask sendUserTask = new SendUserTask() {
            @Override
            protected void onPostExecute(User result) {
                //mirror(result);
                modelHandler.OnModelSent();
            }
        };
        sendUserTask.execute(this);

        //RestRequest createUserRequest = new RestRequest("users/create", Method.POST);
        //createUserRequest.AddParameter("email", Email);
        //createUserRequest.AddParameter("username", Username);
        //createUserRequest.AddParameter("password", Password);

        //IRestResponse<User> createUserResponse = HttpClient.Execute<User>(createUserRequest);

        //if (createUserResponse.Data.Id > 0)
        //{
        //    copy(createUserResponse.Data);
        //    _loggedUser = this;
        //}
        //else
            //respone.Errors.add(new Error("Error Happened while creating new user"));

        if (respone.Errors.size() > 0)
            respone.State = ResponseState.FAIL;

        return respone;
    }

    public Response Read()
    {
        Response respone = new Response();

        if (Email == "" || Password == "")
            respone.Errors.add(new Error("Email or Password isnt set"));

        RetrieveUserTask retrieveUser = new RetrieveUserTask() {
            protected void onPostExecute(User result) {
                isFetched = true;
                copy(result);
                //modelHandler.OnModelRetrieved();
            }
        };
        User user = new User(Email, Password);
        retrieveUser.execute(user);

        //RestRequest loginRequest = new RestRequest("users/login", Method.POST);
        //loginRequest.AddParameter("email", Email);
        //loginRequest.AddParameter("password", Password);

        //IRestResponse<User> loginResponse = HttpClient.Execute<User>(loginRequest);

        //if (loginResponse.Data == null)
        //{
        //    respone.Errors.add(new Error("No connection to internet"));
        //    respone.State = ResponseState.FAIL;
        //    return respone;
        //}

        //if (LoginResponse.Data.Id > 0)
        //{
          //    copy(LoginResponse.Data);
        //loadObjects();
        LoggedInUser = this;
        //}
        //else
        //    respone.Errors.add(new Error("Invalid Email/Password Combination"));

        //if (respone.Errors.size() > 0)
        //    respone.State = ResponseState.FAIL;

        return respone;
    }

    public Response Update()
    {
        Response respone = new Response();

        //try
        //{
        //    String URL = WebserviceURLFull + "/edit";

        //    WebClient webClient = new WebClient();

        //    NameValueCollection formData = new NameValueCollection();

        //    formData["id"] = id;

        //    formData["name"] = name;

        //    formData["barcode"] = barcode;

        //    formData["market_id"] = _market.Id.ToString();

        //    formData["price"] = price.ToString();

        //    formData["weight"] = weight;

        //    formData["description"] = description;

        //    byte[] responseBytes = webClient.UploadValues(URL, "POST", formData);

        //    String responsefromserver = Encoding.UTF8.GetString(responseBytes);

        //    webClient.Dispose();

        //    if (responsefromserver == null)
        //        return false;
        //    else
        //        return true;

        //}
        //catch (Exception ex)
        //{
        //    return false;
        //}
        if (respone.Errors.size() > 0)
            respone.State = ResponseState.FAIL;
        return respone;
    }

    public Response Delete()
    {
        Response respone = new Response();

        //try
        //{
        //    WebClient wb = new WebClient();
        //    String url = WebserviceURLFull + "/delete";
        //    var data = new NameValueCollection();

        //    data["market_id"] = _market.Id.ToString();
        //    data["id"] = id;

        //    byte[] responseBytes = wb.UploadValues(url, "POST", data);

        //    String responsefromserver = Encoding.UTF8.GetString(responseBytes);

        //    if (responsefromserver != null)
        //        return true;

        //    return false;

        //}
        //catch { return false; }
        if (respone.Errors.size() > 0)
            respone.State = ResponseState.FAIL;
        return respone;
    }

    public Response attachObject(Object obj)
    {
        Response respone = new Response();
        if (obj.Files.get(0).Path == "" || obj.SerialNumber == "" || Id <= 0)
            respone.Errors.add(new Error("File or serial or Id isnt set"));


        //RestRequest attachObjectRequest = new RestRequest("objects/create", Method.POST);
        //attachObjectRequest.AddFile("image", obj.Files[0].Path);
        //attachObjectRequest.AddParameter("serial_number", obj.SerialNumber);
        //attachObjectRequest.AddParameter("user_id", Id);

        //IRestResponse<Object> attachObjectResponse = HttpClient.Execute<Object>(attachObjectRequest);
        //if (attachObjectResponse.Data != null)
        //    Objects.Add(attachObjectResponse.Data);
        //else
        //    respone.Errors.Add(new Error("Error Happened while creating new object!"));

        //if (respone.Errors.Count > 0)
        //    respone.State = ResponseState.FAIL;

        return respone;
    }

    protected void copy(User user)
    {

        //CreatedAt = user.CreatedAt;
        //UpdatedAt = user.UpdatedAt;
        Id = user.Id;
        Email = user.Email;
        FirstName = user.FirstName;
        LastName = user.LastName;
    }

    protected void loadObjects()
    {
        //RestRequest objectsRequest = new RestRequest("users/{username}/objects", Method.GET);
        //objectsRequest.AddUrlSegment("username", Username);

        //IRestResponse<List<Object>> objectsResponse = HttpClient.Execute<List<Object>>(objectsRequest);
        //Objects = objectsResponse.Data;
    }

    public Response makePost(Object obj, Post post)
    {
        Response response = new Response();

        if (post.TextPosts.get(0).Paragraph == "" || obj.SerialNumber == "" || Id <= 0)
            response.Errors.add(new Error("Text Post or Serial or Id isnt set"));


        //RestRequest makePostRequest = new RestRequest("posts/create", Method.POST);
        //makePostRequest.AddParameter("user_id", Id);
        //makePostRequest.AddParameter("serial_number", obj.SerialNumber);
        //makePostRequest.AddParameter("paragraph", post.TextPosts[0].Paragraph);

        //IRestResponse<Post> makePostResponse = HttpClient.Execute<Post>(makePostRequest);

        //if (makePostResponse.Data != null)
        //    obj.Posts.Add(makePostResponse.Data);
        //else
        //    response.Errors.Add(new Error("Error Happened while making new post!"));

        //if (response.Errors.Count > 0)
        //    response.State = ResponseState.FAIL;

        return response;
    }

    public Response updateObject(Object obj)
    {
        Response response = new Response();
        //List<Object> userObjects = Objects.Where((userObject) => userObject.SerialNumber == obj.SerialNumber).ToList();
        //if (userObjects.Count <= 0)
        //    response.Errors.Add(new Error("User doesnt have this object"));
        //else
        //{
        //    RestRequest objectUpdateRequest = new RestRequest("objects/{id}/update", Method.POST);
        //    objectUpdateRequest.AddUrlSegment("id", userObjects[0].Id.ToString());

        //    objectUpdateRequest.AddParameter("serial_number", obj.SerialNumber);
        //    objectUpdateRequest.AddFile("image", obj.Files[0].Path);

        //    IRestResponse updateObjectResponse = HttpClient.Execute(objectUpdateRequest);
        //    bool updated = updateObjectResponse.Content.Contains("true");

        //    if (!updated)
        //        response.Errors.Add(new Error("unkown error happened while updating object"));
        //}


        if (response.Errors.size() > 0)
            response.State = ResponseState.FAIL;

        return response;
    }

    public Response FindObject(String serial)
    {
        Response response = new Response();

        for(Object obj:Objects) {
            if(obj.SerialNumber == serial)
            {
                response.Returns.add(obj);
                break;
            }
        }

        return response;
    }
}
