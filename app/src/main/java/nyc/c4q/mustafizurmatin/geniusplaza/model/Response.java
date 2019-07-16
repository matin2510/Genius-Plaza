package nyc.c4q.mustafizurmatin.geniusplaza.model;

import java.util.ArrayList;

/**
 * Created by Mustafizur Matin on 7/16/19.
 */

public class Response {

    /**
     * page : 1
     * per_page : 3
     * total : 12
     * total_pages : 4
     * data : [{"id":1,"email":"george.bluth@reqres.in","first_name":"George","last_name":"Bluth","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"},{"id":2,"email":"janet.weaver@reqres.in","first_name":"Janet","last_name":"Weaver","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"},{"id":3,"email":"emma.wong@reqres.in","first_name":"Emma","last_name":"Wong","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg"}]
     */

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private ArrayList<Users> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<Users> getData() {
        return data;
    }

    public void setData(ArrayList<Users> data) {
        this.data = data;
    }

}
