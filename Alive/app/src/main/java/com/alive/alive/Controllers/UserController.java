package com.alive.alive.Controllers;

import com.alive.alive.Common.Response;
import com.alive.alive.Common.ResponseState;
import com.alive.alive.Common.Input;
import com.alive.alive.Models.AppCommon.User;
/**
 * Created by yessir on 26/09/14.
 */
public class UserController {
    public Response CreateUser(String email, String username, String password)
    {
        Response response = new Response();
        String Email, Username, Password;

        //email = inputs.Where(input => input.Name == "email").ElementAt(0);
        //username = inputs.Where(input => input.Name == "username").ElementAt(0);
        //password = inputs.Where(input => input.Name == "password").ElementAt(0);


        if (email == "")
            response.Errors.add(new Error("User email can't be empty."));
        if (username == "")
            response.Errors.add(new Error("User username can't be empty."));
        if (password == null)
            response.Errors.add(new Error("User password can't be empty."));

        if (response.Errors.size() > 0)
            response.State = ResponseState.FAIL;
        else
        {
            User newUser = new User(
                    email, password
            );

            newUser.Username = username;

            Response serverResponse = newUser.Create();

            if (serverResponse.State == ResponseState.FAIL)
            {
                response.Errors.add(new Error("Unknown error happend while saving user, please try again later"));
                response.State = ResponseState.FAIL;
            }
        }

        return response;
    }

    /// <summary>
    /// Log the user in the system
    /// </summary>
    /// <param name="inputs">List of inputs : email and password</param>
    /// <returns>Result of running the function</returns>
    public Response UserLogIn(String email, String password)
    {
        Response response = new Response();
        //String email, password;

        //email = inputs.Where(input => input.Name == "email").ElementAt(0);
        //password = inputs.Where(input => input.Name == "password").ElementAt(0);


        if (email == "")
            response.Errors.add(new Error("User email can't be empty."));
        if (password == null)
            response.Errors.add(new Error("User password can't be empty."));

        //if (response.Errors.size() > 0)
        //    response.State = ResponseState.FAIL;
        //else
        //{
            User user = new User(
                    email, password
            );

            Response serverResponse = user.Read();

            if (serverResponse.State == ResponseState.FAIL)
            {
                response.Errors.add(new Error("Unknown error happend llogging in user, please try again later"));
                response.State = ResponseState.FAIL;
            }
        //}

        return response;
    }
}
