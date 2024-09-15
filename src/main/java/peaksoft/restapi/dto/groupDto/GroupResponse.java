package peaksoft.restapi.dto.groupDto;

import lombok.*;

@Getter
@Setter
@Builder
public class GroupResponse {

    private Long id;
    private String groupName;
    private String imageLink;
    private String description;

    public GroupResponse(Long id, String groupName, String imageLink, String description) {
        this.id = id;
        this.groupName = groupName;
        this.imageLink = imageLink;
        this.description = description;
    }
}
