package utils.users.pojo;

import lombok.Getter;

import java.util.List;

@Getter
public class GetAllUsersResponse {
    private List<Data> data;
    private Meta meta;

    @Getter
    public static class Data{
        private String gender;
        private String name;
        private String id;
        private String email;
        private String status;
    }

    @Getter
    public static class Meta{
        private Pagination pagination;
    }

    @Getter
    public static class Pagination{
        private String total;
        private String pages;
        private String limit;
        private Links links;
        private String page;
    }

    @Getter
    public static class Links{
        private String next;
        private String current;
        private String previous;
    }
}
