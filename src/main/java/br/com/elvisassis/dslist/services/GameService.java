package br.com.elvisassis.dslist.services;

import br.com.elvisassis.dslist.dto.GameDTO;
import br.com.elvisassis.dslist.dto.GameMinDTO;
import br.com.elvisassis.dslist.entities.Game;
import br.com.elvisassis.dslist.execption.RecordNotFoundException;
import br.com.elvisassis.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = repository.findAll();
        return result.stream()
                .map(game -> game.toMinDTO(game))
                .toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        var result = repository.findById(id).orElseThrow(()-> new RecordNotFoundException());
        return result.toFullDTO(result);
    }
}
