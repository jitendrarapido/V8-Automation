package testdata

import nl.topicus.overheid.javafactorybot.Factory
import nl.topicus.overheid.javafactorybot.definition.Attribute
import org.apache.commons.lang3.RandomStringUtils
import utils.Customer

class CustomerFactory extends Factory<Customer> {

    Map<String, Attribute> attributes = [
            mobileNumber : value { faker.number().numberBetween(2222222222, 5555555555) },
            firstName    : value { faker.name().firstName() },
            lastName     : value { faker.name().firstName() },
            email        : value { RandomStringUtils.randomAlphabetic(4).toLowerCase() + faker.internet().emailAddress() },
            useTruecaller: value { false },

    ]

}
