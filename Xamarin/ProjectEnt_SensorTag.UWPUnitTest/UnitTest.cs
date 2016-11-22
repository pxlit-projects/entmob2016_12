using System;
using Microsoft.VisualStudio.TestPlatform.UnitTestFramework;
using ProjectEnt_SensorTag.UWP.ViewModels;
using System.Diagnostics;

namespace ProjectEnt_SensorTag.UWPUnitTest
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestNavigationLogin()
        {
            var test = new TestNotificationService();
            var login = new LoginViewModel(test);
            login.User = new Model.User();
            login.User.Username = "Francesco";
            login.User.Password = "admininstrator";

            login.Login.Execute(null);
            Debug.WriteLine(test.CurrentPageKey);
            Assert.AreEqual(test.CurrentPageKey, "ProjectEnt_SensorTag.UWP.Views.MenuView");
        }
        [TestMethod]
        public void TestListView()
        {
            var test = new TestNotificationService();
            var login = new MainViewModel(test);

            login.User = new Model.User();
            login.User.Username = "Francesco";
            login.User.Password = "admininstrator";

            login.Temp.CanExecute(null);

            var temp = login.TemperatureList;
            Assert.IsTrue(temp.Count > 0);
        }
    }

    public class TestNotificationService : UWP.Navigation.INavigationService
    {

        private string currentPageKey;

        public string CurrentPageKey
        {
            get { return currentPageKey; }
            set { currentPageKey = value; }
        }

        private bool wentBack = false;

        public bool WentBack
        {
            get { return wentBack; }
            set { wentBack = value; }
        }


        public void GoBack()
        {
            wentBack = true;
        }

        public void NavigateTo(string pageKey)
        {
            this.currentPageKey = pageKey;
        }

        public void NavigateTo(string pageKey, object parameter)
        {
            throw new NotImplementedException();
        }

        public void Navigate(Type sourcePage)
        {
            this.currentPageKey = sourcePage.FullName;
        }

        public void Navigate(Type sourcePage, object parameter)
        {
            this.currentPageKey = sourcePage.FullName;
        }
    }
}
