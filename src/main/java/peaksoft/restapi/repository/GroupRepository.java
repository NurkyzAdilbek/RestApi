package peaksoft.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.restapi.dto.groupDto.GroupResponse;
import peaksoft.restapi.dto.groupDto.SearchResponse;
import peaksoft.restapi.entity.Group;

import java.util.List;
@Repository
public interface GroupRepository  extends JpaRepository<Group, Long> {
    @Query("select new peaksoft.restapi.dto.groupDto.GroupResponse(g.id,g.groupName,g.imageLink,g.description) from Group g" )
    List<GroupResponse>getAllGroups();


    @Query("select new peaksoft.restapi.dto.groupDto.GroupResponse(g.id,g.groupName,g.imageLink,g.description) from Group g where g.id=:id" )
    GroupResponse getGroupById(Long id);


    @Query("select new peaksoft.restapi.dto.groupDto.SearchResponse(g.groupName) from Group g where g.groupName=:word" )
    List<SearchResponse>searchGroupsByGroupName(String word);
}
