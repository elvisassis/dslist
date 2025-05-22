package br.com.elvisassis.dslist.mapprers;

import br.com.elvisassis.dslist.dto.GameDTO;
import br.com.elvisassis.dslist.dto.GameMinDTO;
import br.com.elvisassis.dslist.entities.Game;
import br.com.elvisassis.dslist.projections.GameMinProjection;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    GameMinDTO toMinDTO(Game entity);
    GameDTO toDTO(Game entity);
    Game toEntityMin(GameMinDTO dto);
    Game toEntityFull(GameDTO dto);
    List<GameMinDTO> toMinDTOProjection(List<GameMinProjection> list);
}

