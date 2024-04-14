package br.com.mfsdevsystem.citiesapi.services;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.data.geo.Point;

import br.com.mfsdevsystem.citiesapi.model.City;
import br.com.mfsdevsystem.citiesapi.repository.CityRepository;
import br.com.mfsdevsystem.citiesapi.utils.EarthRadius;
import br.com.mfsdevsystem.citiesapi.utils.StringLocationUtils;

@Service
public class DistanceService {

	Logger log = LoggerFactory.getLogger(DistanceService.class);

	private final CityRepository cityRepository;

	public DistanceService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	/**
	 * 1st option
	 *
	 * @param cityFrom
	 * @param cityTo
	 * @param unit
	 * @return
	 */
	public Double distanceUsingMath(final Long cityFrom, final Long cityTo, final EarthRadius unit) {
		log.info("distanceUsingMath({}, {}, {})", cityFrom, cityTo, unit);

		final List<City> cities = cityRepository.findAllById((Arrays.asList(cityFrom, cityTo)));

		final Double[] locationFrom = StringLocationUtils.transform(cities.get(0).getGeoLocation());
		final Double[] locationTo = StringLocationUtils.transform(cities.get(0).getGeoLocation());
		return doCalculation(locationFrom[0], locationFrom[1], locationTo[0], locationTo[1], unit);
	}

	/**
	 * 2st option
	 *
	 * @param cityFrom
	 * @param cityTo
	 * @param unit
	 * @return
	 */
	public Double distanceByPointsInMiles(final long cityFrom, final long cityTo) {

		log.info("nativePostgresInMilles({}, {})", cityFrom, cityTo);
		return cityRepository.distanceByPoints(cityFrom, cityTo);
	}

	/**
	 * 3rd option
	 *
	 * @param cityFrom
	 * @param cityTo
	 * @param unit
	 * @return
	 */
	Double distanceUsingPoints(final long cityFrom, final Long cityTo, final EarthRadius unit) {

		log.info("distanceUsingPoints({}, {}, {})", cityFrom, cityTo, unit);

		final List<City> cities = cityRepository.findAllById((Arrays.asList(cityFrom, cityTo)));

		Point p1 = cities.get(0).getLocation();
		Point p2 = cities.get(1).getLocation();

		return doCalculation(p1.getX(), p1.getY(), p2.getX(), p2.getY(), unit);
	}

	/**
	 * 4th option
	 *
	 * @param cityFrom
	 * @param cityTo
	 * @return
	 */
	public Double distanceByCubeInMeters(long cityFrom, long cityTo) {
		log.info("distanceByCubeInMeters({}, {})", cityFrom, cityTo);
		final List<City> cities = cityRepository.findAllById(Arrays.asList(cityFrom, cityTo));

		Point p1 = cities.get(0).getLocation();
		Point p2 = cities.get(1).getLocation();

		return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}

	private Double doCalculation(final Double latitude1, final Double longitude1, final Double latitude2,
			final Double longitude2, final EarthRadius earthRadius) {
		double latitude = toRadians(latitude2 - latitude1);
		double longitude = toRadians(longitude2 - longitude1);
		double a = sin(latitude / 2) * cos(toRadians(latitude2)) * sin(longitude / 2) * sin(longitude / 2);
		double c = 2 * atan2(sqrt(a), sqrt(1 - a));
		return earthRadius.getValue() * c;
	}
}
