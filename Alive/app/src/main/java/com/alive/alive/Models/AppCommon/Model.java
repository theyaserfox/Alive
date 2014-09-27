package com.alive.alive.Models.AppCommon;

/**
 * Created by yessir on 26/09/14.
 */
public abstract class Model {
    public int Id;
    public String CreatedAt;
    public String UpdatedAt;
    public static String WebServiceParent = "http://zonlinegamescom.ipage.com/gp/public";
    protected static String _webserviceMockURLParent = "http://zonlinegamescom.ipage.com/smarthypermarket/public/mocks";

    protected Boolean isFetched = false;
    protected OnModelListener modelHandler;
    protected static Boolean isAllFetched = false;
    protected static OnModelListener OnAllModelsRetrieved;
    //abstract public Response Create();
    //abstract public Response Read();
    //abstract public Response Update();
    //abstract public Response Delete();

    public Model() {
    }
    public Boolean isAllFetched()
    {
        return isAllFetched;
    }
    public static void setOnAllModelsRetrieved(OnModelListener onAllModelsRetrieved) {
        OnAllModelsRetrieved = onAllModelsRetrieved;
    }
    public void setModelHandler(OnModelListener modelHandler) {
        this.modelHandler = modelHandler;
    }
}
