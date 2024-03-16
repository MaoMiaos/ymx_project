package com.ymx_project.mapper;

import com.ymx_project.dto.UserDto;
import com.ymx_project.entity.User;
import com.ymx_project.request.UserCreateRequest;
import com.ymx_project.vo.UserVo;
import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
//封装成包在Controller使用
@Component
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateRequest userCreateRequest);

//    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);

}
