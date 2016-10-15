using System;
using System.Threading.Tasks;
using System.Net.Http;
using Newtonsoft.Json;
using System.Text;
using ProjectEnt_SensorTag.Model;

namespace ProjectEnt_SensorTag.Network
{
    public class SendMessage
    {
        private static string website = "http://httpbin.org";

        //public static async Task<T> GetRequest<T>(string location)
        //{
        //    TaskCompletionSource<T> tcs = new TaskCompletionSource<T>();

        //    using (var client = new HttpClient())
        //    {
        //        client.BaseAddress = new Uri(website.ToURL());
        //        client.DefaultRequestHeaders.Accept.Clear();
        //        client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        //        HttpResponseMessage response = await client.GetAsync(location);

        //        if (response.IsSuccessStatusCode)
        //        {
        //            T result = await response.Content.ReadAsAsync<T>();
        //            tcs.TrySetResult(result);
        //        }
        //        else
        //        {
        //            tcs.TrySetException(new Exception());
        //        }

        //        return await tcs.Task;
        //    }
        //}
        public static T PostRequest<T, I>(string location, I item)
        {
            var stringPayload = JsonConvert.SerializeObject(item);
            var httpContent = new StringContent(stringPayload, Encoding.UTF8, "application/json");

            using (var client = new HttpClient())
            {
                var response = client.PostAsync(website, httpContent).Result;
                response.EnsureSuccessStatusCode();
                //response.Content.ReadAsStringAsync().Result
                var result = JsonConvert.DeserializeObject<T>("true");
                return result;
            }
        }
    }
}
