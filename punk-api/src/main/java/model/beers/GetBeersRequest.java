package model.beers;

import model.base.BaseRequest;

public class GetBeersRequest extends BaseRequest<GetBeersRequest> {

    public String params;

    @Override
    public GetBeersRequest getBody() {
        return this;
    }

    public GetBeersRequest(String page, String pagination) {
        params = "?page=" + page + "&per_page=" + pagination;
    }
}