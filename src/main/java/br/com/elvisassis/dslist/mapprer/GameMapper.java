package br.com.elvisassis.dslist.mapprer;

import br.com.elvisassis.dslist.dto.GameDTO;
import br.com.elvisassis.dslist.dto.GameMinDTO;
import br.com.elvisassis.dslist.entities.Game;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    GameMinDTO toMinDTO(Game entity);
    GameDTO toDTO(Game entity);
    Game toEntityMin(GameMinDTO dto);
    Game toEntityFull(GameDTO dto);
}

