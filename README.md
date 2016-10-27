# Death by Detention

This is the code behind the [map]() showing the deaths of immigrant detainees.
Behind the scenes some `Clojure` code takes as input a list of csv containing
the deaths in the following format:

```
Person Name, Year, Facility Name, Facility Address, Contractor, State
```

and outputs a `JSON` file containing the the records parsed and the geolocations
of every facility.

Then there is a completely static website under the `www` directory which expects
the outputted `JSON` data to live in `www/data/deaths-by-detention.json`. By
reading this file the webpage and map are generated.

## Installation

Install [lein](http://leiningen.org/#install) on your platform.

## Usage

From the project's directory:

```
lein run data/*.csv > www/data/deaths-by-detention.json
```

Then by serving the `www` directory from any HTTP server you will see the map
and tables.
