package com.alive.alive.Models.AppCommon;

import com.alive.alive.Common.Response;

/**
 * Created by yessir on 26/09/14.
 */
public class TextPost {
    public String Paragraph;

    public TextPost() { }
    public TextPost(String paragraph)
    {
        Paragraph = paragraph;
    }

    public Response Create()
    {
        return new Response();
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
