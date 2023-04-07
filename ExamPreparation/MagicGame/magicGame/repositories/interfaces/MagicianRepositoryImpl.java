package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.Magician;
import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;

public class MagicianRepositoryImpl implements MagicianRepository<Magician>{

    private Collection<Magician> magiciansRepository;

    public MagicianRepositoryImpl() {
        this.magiciansRepository = new ArrayList<>();
    }

    @Override
    public Collection getData() {
        return magiciansRepository;
    }

    @Override
    public void addMagician(Magician magician) {
        if(magician == null){
            throw new NullPointerException(String.format(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY));
        }
        this.magiciansRepository.add(magician);
    }

    @Override
    public boolean removeMagician(Magician magician) {
        return magiciansRepository.remove(magician);
    }

    @Override
    public Magician findByUsername(String name) {
        return magiciansRepository.stream()
                .filter(m -> name.equals(m.getUsername()))
                .findFirst()
                .orElse(null);
    }
}
