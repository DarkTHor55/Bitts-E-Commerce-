import React from 'react'
import HomeCarousel from '../../Components/HomeCarosuel/HomeCarousel'
import HomeSectionCarousel from '../../Components/HomeSectionCardsCarousel/HomeSectionCarousel';
// import { MenKurta } from '../../../Data/Mens/MenKurta'
import { WomenKurta } from '../../../Data/WomenKutra';
import { MenKurta } from '../../../Data/Kurta/MenKurta';
import { MensJeans } from '../../../Data/Mens/MensJeans';
import{MensShirts} from '../../../Data/Mens/MensShirts';
import { WomenJeans } from '../../../Data/Women/WomenJeans';
import {WomenTop} from '../../../Data/Women/WomenTop';
import {WomenDress} from '../../../Data/Women/WomenDress';
import { MensPant } from '../../../Data/Mens/MensPant';
const Homepage = () => {
  return (
    <div>
      <HomeCarousel/>
      <div className='space-y-20 py-20 flex flex-col justify-center'>
      <HomeSectionCarousel data={MenKurta} sectionName={"Men's Kurta"} />
      <HomeSectionCarousel data={WomenKurta} sectionName={"Women's "}/>
      <HomeSectionCarousel data={MensJeans} sectionName={"Mens's Jeans "}/>
      <HomeSectionCarousel data={MensShirts} sectionName={"Mens's Shirts "}/>
      <HomeSectionCarousel data={WomenJeans} sectionName={"Women's Jeans's "}/>
      <HomeSectionCarousel data={WomenTop} sectionName={"Women's Top's "}/>
      <HomeSectionCarousel data={WomenDress} sectionName={"Women's Dress's "}/>
      <HomeSectionCarousel data={MensPant} sectionName={"Men's Pant's "}/>


      
  

      </div>
    </div>
  )
}

export default Homepage;
