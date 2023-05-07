package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private DiscovererRepository discoverers;
    private SpotRepository spots;
    private int spotCount;

    public ControllerImpl() {
        this.discoverers = new DiscovererRepository();
        this.spots = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;
        if(kind.equals("Archaeologist")){
            discoverer = new Archaeologist(discovererName);
        }else if(kind.equals("Anthropologist")){
            discoverer = new Anthropologist(discovererName);
        }else if(kind.equals("Geologist")){
            discoverer = new Geologist(discovererName);
        }else{
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }
        discoverers.add(discoverer);
        return String.format(ConstantMessages.DISCOVERER_ADDED);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);

        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }
        spots.add(spot);
        return String.format(ConstantMessages.SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        if(discoverers.byName(discovererName) == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
        discoverers.remove(discoverers.byName(discovererName));
        return String.format(ConstantMessages.DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> discovererList = new ArrayList<>(discoverers.getCollection());
        List<Discoverer> suitableDiscoverers = discovererList.stream()
                .filter(d -> d.getEnergy() > 45).collect(Collectors.toList());
        if(suitableDiscoverers.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Operation operation = new OperationImpl();
        operation.startOperation(spots.byName(spotName), suitableDiscoverers);
        long count = suitableDiscoverers.stream()
                .filter(d -> d.getEnergy() == 0).count();
        spotCount++;

        return String.format(ConstantMessages.INSPECT_SPOT, spotName, count);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_SPOT_INSPECT,spotCount));
        sb.append(System.lineSeparator());
        sb.append(ConstantMessages.FINAL_DISCOVERER_INFO).append(System.lineSeparator());
        List<Discoverer> discovererList = new ArrayList<>(discoverers.getCollection());

        for (Discoverer discoverer : discovererList) {
            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_NAME,discoverer.getName())).append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY,discoverer.getEnergy())).append(System.lineSeparator());
            String museumReport =  discoverer.getMuseum().getExhibits().isEmpty()
                    ? "None"
                    : discoverer.getMuseum().getExhibits().stream()
                    .collect(Collectors.joining(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER));
            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS,museumReport)).append(System.lineSeparator());

        }

        return sb.toString().trim();
    }
}
