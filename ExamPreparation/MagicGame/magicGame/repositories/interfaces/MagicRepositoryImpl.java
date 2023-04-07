package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;

public class MagicRepositoryImpl<M> implements MagicRepository<Magic>{

    private Collection<Magic> magicsRepository;

    public MagicRepositoryImpl() {
        this.magicsRepository = new ArrayList<>();
    }

    @Override
    public Collection getData() {
        return magicsRepository;
    }

    @Override
    public void addMagic(Magic magic) {
        if(magic == null){
            throw new NullPointerException(String.format(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY));
        }
        this.magicsRepository.add(magic);
    }

    @Override
    public boolean removeMagic(Magic magic) {
        return magicsRepository.remove(magic);
    }

    @Override
    public Magic findByName(String name) {
        return magicsRepository.stream()
                .filter(m -> name.equals(m.getName()))
                .findFirst()
                .orElse(null);
    }
}
