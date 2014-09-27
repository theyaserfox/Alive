package com.alive.alive.Models.AppCommon;
//package com.alive.alive.Common;

import com.alive.alive.Common.Response;
import com.alive.alive.Common.ResponseState;
import java.util.List;

/**
 * Created by yessir on 26/09/14.
 */
public class Object extends Model {
    public String SerialNumber;
    public List<File> Files;
    //public List<Post> Posts;
    public static String WebserviceURLFull = Model.WebServiceParent + "/objects";


    public Object() { }
    public Object(String serialNumber, List<File> files)
    {
        SerialNumber = serialNumber;
        Files = files;
    }

    public Response Create()
    {
        Response respone = new Response();

        //RestRequest request = new RestRequest("http://zonlinegamescom.ipage.com/gp/public/objects/create", Method.POST);
        //request.AddParameter("serial_number", _serialNumber);
        ////request.AddParameter("user_id", _userId);
        //request.AddFile("image", @"C:\Users\Yaser\Desktop\zedny.jpg");
        //byte[] data;
        //using (MemoryStream ms = new MemoryStream())
        //{
        //    _image.Save(ms, ImageFormat.Bmp);
        //    data = ms.ToArray();
        //    ms.Close();
        //}
        //request.AddFile("image", x => new MemoryStream(data), string.Empty);

        //calling server with restClient
        //RestClient restClient = new RestClient();
        //restClient.ExecuteAsync(request, (response) =>
        //{
        //    if (response.StatusCode == HttpStatusCode.OK)
        //    {
        //        //upload successfull
        //        if (response.Content.Contains("true"))
        //        {
        //            respone.State = ResponseState.SUCCESS;
        //        }
        //        else
        //            respone.State = ResponseState.FAIL;
        //    }
        //    else
        //    {
        //        //error ocured during upload
        //        respone.State = ResponseState.FAIL;
        //    }
        //});
        if (respone.Errors.size() > 0)
            respone.State = ResponseState.FAIL;
        return respone;
    }

    public Response Read()
    {
        Response respone = new Response();

        //string url = User.WebserviceURLFull + "/" + _owners[_owners.Count - 1].Username + "/object?sn=" + this.Serial;
        //string data = null;
        //HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);
        //try
        //{
        //    HttpWebResponse response = (HttpWebResponse)request.GetResponse();
        //    StreamReader sr = new StreamReader(response.GetResponseStream());
        //    data = sr.ReadToEnd();
        //}
        //catch
        //{
        //    respone.State = ResponseState.FAIL;
        //}
        ////if ( == true)
        ////    return true;
        ////else
        ////    return false;

        if (respone.Errors.size() > 0)
            respone.State = ResponseState.FAIL;
        return respone;
    }

    public Response Update()
    {
        Response respone = new Response();

        //try
        //{
        //    string URL = WebserviceURLFull + "/edit";

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

        //    string responsefromserver = Encoding.UTF8.GetString(responseBytes);

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
        //    string url = WebserviceURLFull + "/delete";
        //    var data = new NameValueCollection();

        //    data["market_id"] = _market.Id.ToString();
        //    data["id"] = id;

        //    byte[] responseBytes = wb.UploadValues(url, "POST", data);

        //    string responsefromserver = Encoding.UTF8.GetString(responseBytes);

        //    if (responsefromserver != null)
        //        return true;

        //    return false;

        //}
        //catch { return false; }
        if (respone.Errors.size() > 0)
            respone.State = ResponseState.FAIL;
        return respone;
    }

    //public static List<User> getOwners(RestClient client, String serialNumber)
    //{
    //    RestRequest ownersRequest = new RestRequest("objects/{serialNumber}/owners");
    //    ownersRequest.AddUrlSegment("serialNumber", serialNumber);
    //    IRestResponse<List<User>> ownersResponse = client.Execute<List<User>>(ownersRequest);

    //    return ownersResponse.Data;
    //}
}
