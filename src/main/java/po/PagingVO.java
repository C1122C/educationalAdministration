package po;

public class PagingVO {

    private int curentPageNo = 1;
    private int totalCount;
    private int pageSize=5;
    private int upPageNo;
    private int nextPageNo;
    private int toPageNo = 0;
    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setToPageNo(Integer toPageNo) {
        this.toPageNo = (toPageNo-1) * pageSize ;
        setCurentPageNo(toPageNo);
    }

    public Integer getTopageNo() {
        return toPageNo;
    }

    public int getCurentPageNo() {
        return curentPageNo;
    }

    public void setCurentPageNo(int curentPageNo) {
        if (curentPageNo != 1) {
            this.upPageNo = curentPageNo - 1;
        }
        this.nextPageNo = curentPageNo + 1;

        this.curentPageNo = curentPageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount%pageSize > 0) {
            this.totalCount = (totalCount/pageSize)+1;
        } else {
            this.totalCount = totalCount/pageSize;
        }

    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getUpPageNo() {
        return upPageNo;
    }

    public void setUpPageNo(int upPageNo) {
        this.upPageNo = upPageNo;
    }

    public int getNextPageNo() {
        return nextPageNo;
    }

    public void setNextPageNo(int nextPageNo) {
        this.nextPageNo = nextPageNo;
    }
}
