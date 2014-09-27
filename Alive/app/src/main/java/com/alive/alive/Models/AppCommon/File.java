package com.alive.alive.Models.AppCommon;
import java.lang.UnsupportedOperationException;
import com.alive.alive.Common.Response;
/**
 * Created by yessir on 26/09/14.
 */
public class File extends Model {
    public int Size;
    public String RealName;
    public String UploadedName;
    public String Path;

    public File() { }
    public File(String path)
    {
        Path = path;
    }

    public String Create()
    {
        return "";
    }

    public Response Read()
    {
        return new Response();
    }

    public Response Update()
    {

        return new Response();
    }

    public Response Delete()
    {
        return new Response();
    }
}
