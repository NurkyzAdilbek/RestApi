package peaksoft.restapi.dto.groupDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class SearchResponse {
    private String groupName;

    public SearchResponse(String name) {
        this.groupName = name;
    }
}
