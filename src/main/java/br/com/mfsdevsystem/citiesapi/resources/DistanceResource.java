package br.com.mfsdevsystem.citiesapi.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsystem.citiesapi.services.DistanceService;
import br.com.mfsdevsystem.citiesapi.utils.EarthRadius;

@RestController
@RequestMapping("/distances")
public class DistanceResource {

	private final DistanceService distanceService;

	public DistanceResource(DistanceService distanceService) {
		this.distanceService = distanceService;
	}
	
	Logger log = LoggerFactory.getLogger(DistanceResource.class);
	
	@GetMapping("/by-points")
	public ResponseEntity byPoints(@RequestParam(name = "from") final long cityFrom,
			               @RequestParam(name = "to") final long cityTo) {
		log.info("byPoints");
		return ResponseEntity.ok().body(distanceService.distanceByPointsInMiles(cityFrom, cityTo));
		
	}
	
	@GetMapping("/by-cube")
	public ResponseEntity byCube(@RequestParam(name = "from") final long cityFrom,
			              @RequestParam(name = "to") final long cityTo) {
		log.info("byCube");
		return ResponseEntity.ok().body( distanceService.distanceByCubeInMeters(cityFrom, cityTo));
		
	}
	
	 @GetMapping("/by-math")
	 public ResponseEntity byMath(@RequestParam(name = "from") final Long cityFrom,
	                       @RequestParam(name = "to") final Long cityTo,
	                       @RequestParam final EarthRadius unit) {
	    log.info("byMath");
	    return ResponseEntity.ok().body( distanceService.distanceUsingMath(cityFrom, cityTo, unit));

	 }
}
