using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;

namespace WebFrontend.Data
{
    public class ApiCountry
    {
        public HttpClient client = new HttpClient();

        private List<Country> country = new List<Country>();

        public List<Country> GetCountries() {
            client.GetAsync
            return null;
        }

    }
}
