using System;
using Microsoft.VisualStudio.TestPlatform.UnitTestFramework;
using ProjectEnt_SensorTag.UWP.ViewModels;

namespace ProjectEnt_SensorTag.UWPUnitTests
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestNavigationLogin()
        {
            var test = new TestNotificationService();
            var login = new LoginViewModel(test);

            login.Login.Execute(null);

            Assert.AreEqual(test.CurrentPageKey, "ProjectEnt_SensorTag.UWP.Views.MenuView");
        }
        [TestMethod]
        public void TestListView()
        {
            var test = new TestNotificationService();
            var login = new MainViewModel(test);

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
